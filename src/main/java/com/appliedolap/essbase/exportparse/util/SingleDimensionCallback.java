package com.appliedolap.essbase.exportparse.util;

import com.appliedolap.essbase.exportparse.model.Dimension;

import java.nio.file.FileVisitResult;

public abstract class SingleDimensionCallback extends AbstractApplicationWalkerCallback implements ApplicationWalker.Callback {

    private final String dimensionName;

    protected SingleDimensionCallback(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    @Override
    public FileVisitResult startDimension(Dimension dimension) {
        return dimensionName.equals(dimension.getName()) ?
                FileVisitResult.CONTINUE :
                FileVisitResult.SKIP_SUBTREE;
    }

}
