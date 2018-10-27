package pl.dk.consumer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

public class CustomJsonDeserializer<T> extends JsonDeserializer<T> {
    public CustomJsonDeserializer(Class<T> targetType) {
        // defaults from superclass
        super(targetType);

        this.addTrustedPackages("pl.dk.producer");
    }
}
