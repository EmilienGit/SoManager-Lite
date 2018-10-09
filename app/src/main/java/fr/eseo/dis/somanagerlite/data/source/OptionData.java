package fr.eseo.dis.somanagerlite.data.source;

import java.util.Arrays;
import java.util.List;

public class OptionData {

    private static List<fr.eseo.dis.somanagerlite.data.Option> LIST_OPTION;

    private static fr.eseo.dis.somanagerlite.data.Option[] OPTIONS = new fr.eseo.dis.somanagerlite.data.Option[]{
            new fr.eseo.dis.somanagerlite.data.Option(1, "My Juries"),
            new fr.eseo.dis.somanagerlite.data.Option(1, "Posters"),
            new fr.eseo.dis.somanagerlite.data.Option(1, "Mark"),
            new fr.eseo.dis.somanagerlite.data.Option(1, "Subject")
    };

    private OptionData() {
    }

    public static List<fr.eseo.dis.somanagerlite.data.Option> getOptions() {
        if (LIST_OPTION == null) {
            LIST_OPTION = Arrays.asList(OPTIONS);
        }
        return LIST_OPTION;
    }
}
