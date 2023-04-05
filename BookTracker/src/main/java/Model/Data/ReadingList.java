package Model.Data;

import java.util.ArrayList;
import java.util.List;

public class ReadingList {
    ArrayList<ReadingListEntry> readingList;

    public ReadingList(ArrayList<ReadingListEntry> readingList) {
        this.readingList = readingList;
    }
    public void addReadingListEntry(ReadingListEntry entry){
        readingList.add(entry);
    }

    public ArrayList<ReadingListEntry> GetUnownedBooks(){
        return (ArrayList<ReadingListEntry>) readingList.stream().filter(e-> !e.owned()).toList();
    }
    //TODO Regex
    public List<ReadingListEntry> searchByTitle(String title) {
        return readingList.stream().filter(e -> e.book().Title().contains(title)).toList();
    }

    public List<ReadingListEntry> searchByAuthor(String author) {
        return readingList.stream().filter(e -> e.book().Author().contains(author)).toList();
    }

    public void removeEntry(ReadingListEntry entryToRemove){
        readingList.remove(entryToRemove);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ReadingListEntry e:readingList
             ) {
            result.append(e.toString()).append(";");
        }
        return result.toString();
    }
}
