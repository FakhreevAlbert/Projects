package com.example.controller;

import com.example.domain.Bookmark;
import com.example.service.BookmarksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookmarks")
public class BookmarksController {
private final BookmarksService bookmarksService;

    public BookmarksController(BookmarksService bookmarksService) {
        this.bookmarksService = bookmarksService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("bookmarks", bookmarksService.findAll());
        return "bookmarks";
    }
    @GetMapping("/read")
    public String getRead(Model model){
        model.addAttribute("bookmarks", bookmarksService.findReadAll());
        return "read";
    }



    @GetMapping("/find")
    public String getBookmarks(@RequestParam(defaultValue = "0") String tag, Model model){
        model.addAttribute("bookmarks", bookmarksService.findByTag(tag));
        return "find";
    }

    @PostMapping
    public String addBookmark(@ModelAttribute Bookmark bookmark){
        bookmarksService.addBookmark(bookmark);
        return "redirect:/bookmarks";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable int id){
        bookmarksService.delete(id);
        return "redirect:/bookmarks";
    }
    @PostMapping("/{id}/send")
    public String sendInRead(@PathVariable int id){
        bookmarksService.sendInRead(id);
        return "redirect:/bookmarks";
    }
    @PostMapping("/read/{id}")
    public String sendInReadLater(@PathVariable int id){
        bookmarksService.sendInReadLater(id);
        return "redirect:/bookmarks/read";
    }
    @PostMapping("/read/{id}/delete")
    public String deleteRead(@PathVariable int id) {
        bookmarksService.delete(id);
        return "redirect:/bookmarks/read";
    }


}
