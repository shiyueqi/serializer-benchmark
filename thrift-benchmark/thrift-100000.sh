JAVA_HOME="/usr/local/jdk1.7.0_80"
JAVA_OPTS="-Xms512M -Xmx512M"

APP_HOME="./target"
APP_MAINCLASS="com.unionpay.serializer.thrift.ThriftTest"
CLASSPATH=".:./$APP_HOME/classes:./$APP_HOME/lib/*"

APP_ARGS="100000"
APP_LOG_FILE="thrift_benchmark_$APP_ARGS.log"

nohup $JAVA_HOME/bin/java $JAVA_OPTS -classpath $CLASSPATH $APP_MAINCLASS $APP_ARGS > $APP_LOG_FILE &