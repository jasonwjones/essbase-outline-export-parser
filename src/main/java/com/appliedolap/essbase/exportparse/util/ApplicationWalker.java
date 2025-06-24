package com.appliedolap.essbase.exportparse.util;

import com.appliedolap.essbase.exportparse.model.Application;
import com.appliedolap.essbase.exportparse.model.Dimension;
import com.appliedolap.essbase.exportparse.model.Member;

public class ApplicationWalker {

    public static void walk(Application application, Callback callback) {
        for (Dimension dimension : application.getDimensions()) {
            if (callback.startDimension(dimension)) {
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

        boolean startDimension(Dimension dimension);

        void endDimension(Dimension dimension);

        void member(Member member, int generation);

    }

    public abstract static class SingleDimensionCallback implements Callback {

        private final String dimensionName;

        protected SingleDimensionCallback(String dimensionName) {
            this.dimensionName = dimensionName;
        }

        @Override
        public boolean startDimension(Dimension dimension) {
            return dimensionName.equals(dimension.getName());
        }

        @Override
        public void endDimension(Dimension dimension) {
        }

        protected static String indent(int times) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < times; i++) {
                builder.append("    ");
            }
            return builder.toString();
        }

    }

}