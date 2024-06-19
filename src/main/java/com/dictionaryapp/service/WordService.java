package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDto;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;
    public WordService(WordRepository wordRepository, LanguageRepository languageRepository, UserRepository userRepository, UserSession userSession) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public void add(AddWordDto data) {
        Word word = new Word();

        word.setDate(data.getDate());
//        word.setLanguage(data.getLanguage());

        // TODO: Save and attach correct user + language
    }
}
