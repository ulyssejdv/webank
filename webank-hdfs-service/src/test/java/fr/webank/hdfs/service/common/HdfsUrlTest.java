package fr.webank.hdfs.service.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ulysse on 04/01/2018.
 */
public class HdfsUrlTest {

    @Test
    public void buildStringUrlShouldReturnTheGoodConcatenedStringWithOptions() {

        List<String> options = new ArrayList<String>();
        options.add("a=1");
        options.add("toto=titi");

        HdfsUrl hdfsUrl = new HdfsUrl(
                "http://namenode:8888",
                "/base-path",
                options
        );

        String expected = "http://namenode:8888/base-path?a=1&toto=titi";

        Assert.assertEquals(expected, hdfsUrl.buildStringUrl());
    }

    @Test
    public void buildStringUrlShouldReturnTheGoodConcatenedStringWithoutOptions() {

        HdfsUrl hdfsUrl = new HdfsUrl(
                "http://namenode:8888",
                "/base-path"
        );

        String expected = "http://namenode:8888/base-path";

        Assert.assertEquals(expected, hdfsUrl.buildStringUrl());
    }

}