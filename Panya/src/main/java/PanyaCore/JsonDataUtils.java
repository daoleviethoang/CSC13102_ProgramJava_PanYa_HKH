package PanyaCore;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class hỗ trợ cách đọc viết file JSON trong dự án Pan-ya
 */
public class JsonDataUtils {

    /**
     * Lưu List<Product> sang file định dạng json
     * 
     * @param path         đường dẫn đến file cần lưu
     * @param list         danh sách các object T
     * @param objectName   tên của object, tên này sẽ là key khi lưu thành file
     * @param toJSONObject hàm chuyển đổi object thành JSON
     * @return <code>true</code> nếu lưu file thành công, <code>false</code> cho các
     *         trường hợp khác
     */
    public static <T> boolean saveObjectList(String path, List<T> list, String objectName,
            Function<T, JSONObject> toJSONObject) {

        try {
            Objects.requireNonNull(path);
            Objects.requireNonNull(list);

            var jsonList = new JSONArray();
            for (var object : list) {
                var productDetail = toJSONObject.apply(object);

                var productJson = new JSONObject();
                productJson.put(objectName, productDetail);

                jsonList.put(productJson);
            }

            try (var fout = new FileWriter(path)) {
                fout.write(jsonList.toString(4));
            }

            return true;
        } catch (NullPointerException | IOException | JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Đọc từ file ra một <code>List<T></code> định dạng <code>JSON</code>
     * 
     * @param path       Đường dẫn đến file json có định dạng để đọc ra một danh
     *                   sách các Product
     * @param JsonParser Hàm chuyển đổi JSONObject sang Object
     * @return List<T>, trả về <code>null</code> nếu file có vấn đề
     */
    public static <T> List<T> readObjectList(String path, Function<JSONObject, T> JsonParser) {
        try {

            // Đọc toàn bộ các bytes trong một file, tạo String
            var fileContent = new String(Files.readAllBytes(Path.of(path)));
            var jsonList = new JSONArray(fileContent);

            //System.out.println(jsonList.toString(4));

            List<T> list = new ArrayList<>();

            // Duyệt từng phần từ trong jsonList, parse sang Object, thêm vào danh
            // sách object
            jsonList.forEach(ele -> list.add(JsonParser.apply((JSONObject) ele)));

            return list;
        } catch (OutOfMemoryError | IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static<T> List<T> toObjectList(JSONArray jsonList, Function<JSONObject, T> JsonParser) {
        try {
            List<T> list = new ArrayList<>();

            // Duyệt từng phần từ trong jsonList, parse sang Object, thêm vào danh
            // sách object
            jsonList.forEach(ele -> list.add(JsonParser.apply((JSONObject) ele)));

            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
