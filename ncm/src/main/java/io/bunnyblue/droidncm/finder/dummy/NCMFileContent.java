package io.bunnyblue.droidncm.finder.dummy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class NCMFileContent {

    /**
     * An array of sample (dummy) items.
     */
    final List<NCMLocalFile> ITEMS = new ArrayList<NCMLocalFile>();


    private static NCMLocalFile createDummyItem(int position) {
        return new NCMLocalFile(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public void addFile(NCMLocalFile ncmLocalFile) {
        ITEMS.add(ncmLocalFile);
    }

    public List<NCMLocalFile> getITEMS() {
        return ITEMS;
    }

    public File[] getFiles() {
        File[] files = new File[ITEMS.size()];
        for (int i = 0; i < ITEMS.size(); i++) {
            files[i] = new File(ITEMS.get(i).localPath);
        }
        return files;
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class NCMLocalFile {
        public String id;
        public String content;
        public String details;
        public String localPath;
        public String targetPath;

        public NCMLocalFile() {

        }

        public NCMLocalFile(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
