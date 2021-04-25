package com.tutorial.graphql.graphqltutorial.config;

import com.tutorial.graphql.graphqltutorial.dataloader.BatchDataLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoaderConfig {

    @Bean
    public DataLoaderRegistry dataLoaderRegistry(List<BatchDataLoader<?, ?>> loaders) {
        var dataLoaderRegistry = new DataLoaderRegistry();

        loaders.forEach(loader -> dataLoaderRegistry.register(loader.getLoaderName(), createLoader(loader)));

        return dataLoaderRegistry;
    }

    private DataLoader<?, ?> createLoader(BatchDataLoader<?, ?> loader) {
        return DataLoader.newDataLoader(loader, loader.getDataLoaderOptions());
    }
}
