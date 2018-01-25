package fr.webank.hdfs.service.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ulysse on 04/01/2018.
 */
public class HdfsUrl {
    private String nameNode;
    private String basePath;
    private List<String> options;

    public HdfsUrl(String nameNode, String basePath) {
        this.nameNode = nameNode;
        this.basePath = basePath;
        this.options = new ArrayList<String>();
    }

    public HdfsUrl(String nameNode, String basePath, List<String> options) {
        this.nameNode = nameNode;
        this.basePath = basePath;
        this.options = options;
    }

    public String buildStringUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.nameNode);
        stringBuilder.append(this.basePath);
        stringBuilder.append(this.concatOptions());
        return stringBuilder.toString();
    }

    private String concatOptions() {
        StringBuilder sb = new StringBuilder();
        if (!this.options.isEmpty()) {
            sb.append("?");
        }
        sb.append(
                this.options.stream().collect(Collectors.joining("&"))
        );
        return sb.toString();
    }
}
