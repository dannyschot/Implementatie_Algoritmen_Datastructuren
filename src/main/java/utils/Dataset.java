package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Dataset {
    JSONHandler jsonHandler;
    JSONObject jsonObject;

    public Dataset() throws IOException, ParseException {
        jsonHandler = new JSONHandler();
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
    }
    public ArrayList<Integer> getEigenLijst() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "eigen_lijst");

        return jsonHandler.convertToIntegerArray(jsonArray);
    }

    public ArrayList<Long> getLijstAflopend2() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_aflopend_2");

        return jsonHandler.convertToLongArray(jsonArray);
    }

    public ArrayList<Long> getLijstOplopend2() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_Oplopend_2");

        return jsonHandler.convertToLongArray(jsonArray);
    }

    public ArrayList<Double> getFloat8001() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_float_8001");

        return jsonHandler.convertToDoubleArray(jsonArray);
    }

    public ArrayList<Integer> getLijstGesorteerdAflopend3() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_gesorteerd_aflopend_3");

        return jsonHandler.convertToIntegerArray(jsonArray);
    }

    public ArrayList<Long> getLijstGesorteerdOplopend3() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_gesorteerd_oplopend_3");

        return jsonHandler.convertToLongArray(jsonArray);
    }

    public ArrayList<Long> getLijstHerhaald1000() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_herhaald_1000");


        return jsonHandler.convertToLongArray(jsonArray);
    }

    public ArrayList<Integer> getLijstLeeg0() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_herhaald_1000");

        return jsonHandler.convertToIntegerArray(jsonArray);
    }

    public ArrayList<Integer> getLijstNull1() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_null_1");

        return jsonHandler.convertToIntegerArray(jsonArray);
    }

    public ArrayList<Integer> getLijstNull3() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_null_3");

        return jsonHandler.convertToIntegerArray(jsonArray);
    }

    public ArrayList<Long> getLijstOplopend1000() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_oplopend_10000");


        return jsonHandler.convertToLongArray(jsonArray);
    }

    public ArrayList<Long> getLijstWillekeurig10000() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_willekeurig_10000");

        return jsonHandler.convertToLongArray(jsonArray);
    }

    public ArrayList<Long> getLijstWillekeurig3() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_willekeurig_3");
        System.out.println(jsonArray.get(0).getClass().getSimpleName());
        return jsonHandler.convertToLongArray(jsonArray);
    }

    public ArrayList<String> getLijstMetStrings() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_met_strings");

        return jsonHandler.convertToStringArray(jsonArray);
    }

    public ArrayList<String> getLijstGesorteerdeStrings() {
        JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, "lijst_gesorteerde_strings");

        return jsonHandler.convertToStringArray(jsonArray);
    }
}
