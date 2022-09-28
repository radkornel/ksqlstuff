package example.ksqldb;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.sql.Timestamp;

import static org.apache.kafka.common.utils.Utils.sleep;


@UdfDescription(name = "SleepOver", description = "Sleep for the given time (in ms), Requires INT as parameter and returns the (after sleep) timestamp as String")
public class SleepOver {

    @Udf(description = "Sleep for the given time")
    public String SleepOver(@UdfParameter(value = "milisecs")
                                final int milisecs) {
            sleep(milisecs);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            return timestamp.toString();
        }

}