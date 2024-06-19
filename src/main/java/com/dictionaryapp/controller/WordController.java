package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.AddWordDto;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import jdk.internal.org.jline.reader.History;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController {

    private WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public String addWord() {

        return "word-add";
    }

    @PostMapping("/words")
    public String doAddWord(@Valid AddWordDto data,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addWordData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.bindingResult.addWordData", bindingResult);

            return "redirect:words";
        }

        wordService.add(data);

        return "redirect:/words";
    }
}
