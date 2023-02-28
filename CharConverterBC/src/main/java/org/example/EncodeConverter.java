package org.example;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import io.confluent.ksql.util.BytesUtils;
import java.nio.ByteBuffer;

@UdfDescription(name = "STRMNG_ISO88592_TO_UTF8_BC", description = "Modify a specific byte from 0 to 10 (00 to 0A in hex), and change the given ISO-8859-2 encoded Bytes to a UTF8 String")
public class EncodeConverter {
    @Udf(description = "Modifies and converts the given BYTES value to STRING in the specified encoding.")
    public String STRMNG_ISO88592_TO_UTF8_BC(@UdfParameter(value = "value") final ByteBuffer value) {
        String output = "DefaultString";
        try {
            byte[] bytes_iso88592 = BytesUtils.getByteArray(value);
            for(int i=0; i<bytes_iso88592.length; i++){
                if(bytes_iso88592[i]==0){
                    bytes_iso88592[i]=10;
                }
            }
            output = new String(bytes_iso88592, "ISO-8859-2");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.print(" UDFExceptionCaught: " + e + " message: " + e.getMessage() + " ");
        } finally {
            return output;
        }
    }
}
