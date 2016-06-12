package com.gdwii.util.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gdwii.util.time.DateTimeUtil;

import java.io.IOException;
import java.time.LocalDateTime;


public class CustomObjectMapper extends ObjectMapper{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5325543428275112290L;

	public CustomObjectMapper() {
		super();
		getSerializerProvider().setNullValueSerializer(new NullSerializer());
		
		SimpleModule module = new SimpleModule();
		module.addDeserializer(LocalDateTime.class, new LocalDateTimeJsonDeserializer());
		module.addSerializer(LocalDateTime.class, new LocalDateTimeJsonSerializer());
		registerModule(module);
	}

	private class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime>{
		@Override
		public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
				throws IOException, JsonProcessingException {
			gen.writeObject(DateTimeUtil.format(value));
		}
	}
	
	private class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime>{
		@Override
		public LocalDateTime deserialize(JsonParser p, DeserializationContext ctext)
				throws IOException, JsonProcessingException {
			return DateTimeUtil.parseDateTime(p.getValueAsString());
		}
	}
	
	//null的JSON序列  
    private class NullSerializer extends JsonSerializer<Object> {  
        public void serialize(Object value, JsonGenerator jgen,  
                SerializerProvider provider) throws IOException,  
                JsonProcessingException {  
            jgen.writeString("");  
        }  
    }  
}