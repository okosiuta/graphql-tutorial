package com.tutorial.graphql.graphqltutorial.util;

import graphql.relay.ConnectionCursor;
import graphql.relay.DefaultConnectionCursor;
import graphql.relay.Edge;

import java.nio.ByteBuffer;

import static java.lang.Long.BYTES;
import static java.util.Base64.getDecoder;
import static java.util.Base64.getEncoder;
import static java.util.Objects.nonNull;

public class ConnectionUtils {

    private ConnectionUtils() {
        throw new UnsupportedOperationException();
    }

    public static ConnectionCursor from(Long id) {
        var buffer = ByteBuffer.allocate(BYTES);

        buffer.putLong(id);

        return new DefaultConnectionCursor(getEncoder().encodeToString(buffer.array()));
    }

    public static long from(String cursor) {
        var bytes = getDecoder().decode(cursor);
        var buffer = ByteBuffer.allocate(bytes.length);

        buffer.put(bytes);
        buffer.flip();

        return buffer.getLong();
    }

    public static <T> ConnectionCursor getCursor(Edge<T> edge) {
        return nonNull(edge)
                ? edge.getCursor()
                : null;
    }
}
