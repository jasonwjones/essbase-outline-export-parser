package com.appliedolap.essbase.exportparse.util;

import com.appliedolap.essbase.exportparse.model.Application;
import com.appliedolap.essbase.exportparse.model.Dimension;
import com.appliedolap.essbase.exportparse.model.Member;

import java.nio.file.FileVisitResult;

public class ApplicationWalker {

    public static void walk(Application application, Callback callback) {
        for (Dimension dimension : application.getDimensions()) {
            if (callback.startDimension(dimension) == FileVisitResult.CONTINUE) {
                walk(dimension, 0, callback);
                callback.endDimension(dimension);
            }
        }
    }

    private static void walk(Member member, int generation, Callback callback) {
        callback.member(member, generation);
        if (member.getMembers() != null) {
            for (Member child : member.getMembers()) {
                walk(child, generation + 1, callback);
            }
        }
    }

    public interface Callback {

        FileVisitResult startDimension(Dimension dimension);

        void endDimension(Dimension dimension);

        void member(Member member, int generation);

    }

}