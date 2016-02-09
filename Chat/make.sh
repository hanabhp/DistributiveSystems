echo "******************************"
echo "******************************"
echo "Interfaces"

echo
echo "Client"
javac -d classes -classpath .:classes src/Client.java
jar cvf lib/Client.jar classes/Client.class
echo
echo "Server"
javac -d classes -classpath .:classes src/Chat.java
jar cvf lib/Chat.jar classes/Chat.class

echo ""
echo "******************************"
echo "******************************"
echo "Remote object implementation"
echo
echo "Client"
javac -d classes -classpath .:classes src/ClientImpl.java
jar cvf lib/ClientImpl.jar classes/ClientImpl.class
echo
echo "Server"
javac -d classes -classpath .:classes src/ChatImpl.java
jar cvf lib/ChatImpl.jar classes/ChatImpl.class

echo ""
echo "******************************"
echo "Server side"
javac -d classes -cp .:classes:lib/Chat.jar:ChatImpl.jar:Client.jar src/ChatServer.java

echo ""
echo "******************************"
echo "Client side"
javac -d classes -cp .:classes:lib/Chat.jar src/ChatClient.java
