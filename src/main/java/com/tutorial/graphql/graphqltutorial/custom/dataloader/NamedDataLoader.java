package com.tutorial.graphql.graphqltutorial.custom.dataloader;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoaderOptions;

public interface NamedDataLoader<T, R> extends BatchLoader<T, R> {

    String getLoaderName();

    default DataLoaderOptions getDataLoaderOptions() {
        return DataLoaderOptions.newOptions()
                .setCachingEnabled(false);
    }
}
