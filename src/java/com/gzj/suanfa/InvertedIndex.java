package com.gzj.suanfa;

import java.util.*;

public class InvertedIndex {
    private Map<String, List<Integer>> invertedIndex;

    public InvertedIndex() {
        invertedIndex = new HashMap<>();
    }

    public void addDocument(int docId, String[] terms) {
        for (String term : terms) {
            if (!invertedIndex.containsKey(term)) {
                invertedIndex.put(term, new ArrayList<>());
            }
            invertedIndex.get(term).add(docId);
        }
    }

    public List<Integer> search(String term) {
        if (invertedIndex.containsKey(term)) {
            return invertedIndex.get(term);
        } else {
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();

        // 添加文档
        invertedIndex.addDocument(1, new String[]{"apple", "banana", "orange"});
        invertedIndex.addDocument(2, new String[]{"apple", "grape"});
        invertedIndex.addDocument(3, new String[]{"banana", "orange", "grape"});
        invertedIndex.addDocument(4, new String[]{"apple"});

        // 搜索词项
        String searchTerm = "apple";
        List<Integer> results = invertedIndex.search(searchTerm);

        System.out.println("Documents containing '" + searchTerm + "':");
        if (results.isEmpty()) {
            System.out.println("No documents found");
        } else {
            for (int docId : results) {
                System.out.println("Document " + docId);
            }
        }
    }
}

