package com.example.service;

import com.example.domain.Bookmark;
import com.example.repository.BookmarksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarksService {
    private final BookmarksRepository bookmarksRepository;

    public BookmarksService(BookmarksRepository bookmarksRepository) {
        this.bookmarksRepository = bookmarksRepository;
    }

    public List<Bookmark> findAll() {
        return bookmarksRepository.findAll();
    }

    public List<Bookmark> findReadAll() {
    return bookmarksRepository.findReadAll();
    }

    public void addBookmark(Bookmark bookmark){
        bookmarksRepository.addBookmark(bookmark);
    }

    public void delete(int id){
        bookmarksRepository.delete(id);
    }

    public List<Bookmark> findByTag(String tag){
        List<Bookmark> later = findAll();
        List<Bookmark> read = findReadAll();
        List<Bookmark> withTag = new ArrayList<>();
        for (int i = 0; i < later.size(); i ++){
            if (later.size() > 0){
                String laterTag = later.get(i).getTag();
                String[] splitTag = laterTag.split("#", -1);
                for (int j = 0; j < splitTag.length; j ++){
                    if (splitTag[j].equals(tag)){
                        withTag.add(later.get(i));
                    }
                }

            }
        }
        for (int i = 0; i < read.size(); i ++){
            if (read.size() > 0){
                String readTag = read.get(i).getTag();
                String[] splitTag = readTag.split("#", -1);
                for (int j = 0; j < splitTag.length; j ++){
                    if (splitTag[j].equals(tag)){
                        withTag.add(read.get(i));
                    }
                }

            }
        }

        return withTag;
    }

    public List<Bookmark> findAllBookmarks() {

        return bookmarksRepository.findAllBookmarks();
    }
    public void sendInRead(int id){
        bookmarksRepository.sendInRead(id);
    }

    public void sendInReadLater(int id){
        bookmarksRepository.sendInReadLater(id);
    }
}
