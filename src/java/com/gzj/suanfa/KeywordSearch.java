package com.gzj.suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordSearch {
    private Map<String, List<Integer>> keywordIndex;

    public KeywordSearch() {
        keywordIndex = new HashMap<>();
    }

    public void addDocument(int docId, String[] keywords) {
        for (String keyword : keywords) {
            if (!keywordIndex.containsKey(keyword)) {
                keywordIndex.put(keyword, new ArrayList<>());
            }
            keywordIndex.get(keyword).add(docId);
        }
    }

    public List<Integer> search(String query) {
        String[] keywords = query.split(" ");
        List<Integer> results = new ArrayList<>();

        if (keywords.length == 0) {
            return results;
        }

        if (keywordIndex.containsKey(keywords[0])) {
            results.addAll(keywordIndex.get(keywords[0]));
        }

        for (int i = 1; i < keywords.length; i++) {
            String keyword = keywords[i];
            if (keywordIndex.containsKey(keyword)) {
                results.retainAll(keywordIndex.get(keyword));
            } else {
                results.clear();
                break;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        KeywordSearch keywordSearch = new KeywordSearch();

        // 添加文档
        keywordSearch.addDocument(1, new String[]{"apple", "banana", "orange"});
        keywordSearch.addDocument(2, new String[]{"apple", "grape"});
        keywordSearch.addDocument(3, new String[]{"banana", "orange", "grape"});
        keywordSearch.addDocument(4, new String[]{"apple"});

        // 搜索关键词
        String query = "apple banana";
        List<Integer> results = keywordSearch.search(query);

        System.out.println("Documents matching query '" + query + "':");
        if (results.isEmpty()) {
            System.out.println("No documents found");
        } else {
            for (int docId : results) {
                System.out.println("Document " + docId);
            }
        }
    }
}
