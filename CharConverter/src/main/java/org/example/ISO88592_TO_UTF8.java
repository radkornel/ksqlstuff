package org.example;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import io.confluent.ksql.util.BytesUtils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

@UdfDescription(name = "ISO88592_TO_UTF8", description = "Change the given ISO-8859-2 encoded Bytes to a UTF8 String")
public class ISO88592_TO_UTF8 {
    @Udf(description = "Converts the given BYTES value to STRING in the specified encoding.")
    public String iso88592_to_utf8(@UdfParameter(description = "The bytes value to convert.") final ByteBuffer value) throws UnsupportedEncodingException {
        byte[] bytes_iso88592 = BytesUtils.getByteArray(value);
        return new String(bytes_iso88592, "ISO-8859-2");
    }
}
