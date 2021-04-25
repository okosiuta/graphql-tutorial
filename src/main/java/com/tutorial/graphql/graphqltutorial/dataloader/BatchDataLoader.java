package com.tutorial.graphql.graphqltutorial.dataloader;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoaderOptions;

public interface BatchDataLoader<T, R> extends BatchLoader<T, R> {

    String getLoaderName();

    default DataLoaderOptions getDataLoaderOptions() {
        return DataLoaderOptions.newOptions()
                .setCachingEnabled(false);
    }
}
