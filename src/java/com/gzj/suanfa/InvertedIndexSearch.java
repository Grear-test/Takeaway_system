package com.gzj.suanfa;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.suanfa
 * @className: sousuo
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/28 0:05
 * @version: 1.0
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvertedIndexSearch {
    private Map<String, Set<String>> invertedIndex;

    public InvertedIndexSearch() {
        invertedIndex = new HashMap<>();
    }

    // 构建倒排索引
    public void buildInvertedIndex(Map<String, List<String>> documents) {
        for (String documentId : documents.keySet()) {
            List<String> keywords = documents.get(documentId);
            for (String keyword : keywords) {
                invertedIndex.computeIfAbsent(keyword, k -> new HashSet<>()).add(documentId);
            }
        }
    }

    // 根据关键词搜索
    public Set<String> searchByKeyword(String keyword) {
        return invertedIndex.getOrDefault(keyword, new HashSet<>());
    }

    public static void main(String[] args) {
        InvertedIndexSearch searchEngine = new InvertedIndexSearch();

        // 假设有一些文档和它们的关键词
        Map<String, List<String>> documents = new HashMap<>();
//        documents.put("doc1", List.of("algorithm", "search", "data"));
//        documents.put("doc2", List.of("data", "structure", "index"));
//        documents.put("doc3", List.of("search", "algorithm", "index"));

        // 构建倒排索引
        searchEngine.buildInvertedIndex(documents);

        // 搜索关键词 "search"
        String keywordToSearch = "search";
        Set<String> result = searchEngine.searchByKeyword(keywordToSearch);

        // 输出搜索结果
        System.out.println("包含关键词 '" + keywordToSearch + "' 的文档有：" + result);
    }
}

