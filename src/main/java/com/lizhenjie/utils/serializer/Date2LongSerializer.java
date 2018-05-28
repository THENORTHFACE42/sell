package com.lizhenjie.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 17:52 2018/5/7
 * @Modified By:
 */
public class Date2LongSerializer extends JsonSerializer<Date>{

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime()/1000);
    }
}
