package com.appliedolap.essbase.exportparse.util;

import com.appliedolap.essbase.exportparse.model.Dimension;
import com.appliedolap.essbase.exportparse.model.Member;

import java.nio.file.FileVisitResult;

public class AbstractApplicationWalkerCallback implements ApplicationWalker.Callback {

    @Override
    public FileVisitResult startDimension(Dimension dimension) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public void endDimension(Dimension dimension) {
        // default is nothing
    }

    @Override
    public void member(Member member, int generation) {
        // default is nothing
    }

    protected static String indent(int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append("    ");
        }
        return builder.toString();
    }

}