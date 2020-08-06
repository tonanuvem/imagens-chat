# Imagens Upload Microservice Java Quarkus

Demonstração usando Quarkus: the Supersonic Subatomic Java Framework.

website: https://quarkus.io/

## Running the app

```
git clone
cd chat-websickets-microservice
chmod +x mvnw
./mvnw quarkus:dev
```

## Criando o DynamoDB Local

```
docker run --publish 8000:8000 amazon/dynamodb-local:1.11.477 -jar DynamoDBLocal.jar -inMemory -sharedDb

aws dynamodb create-table --table-name ImagensDB --endpoint-url http://localhost:8000  --attribute-definitions AttributeName=idName,AttributeType=S --key-schema AttributeName=idName,KeyType=HASH --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1

aws dynamodb list-tables --endpoint-url http://localhost:8000
```

## Configs do DynamoDB Local : application.properties (com DynamoDB local)

```
quarkus.dynamodb.endpoint-override=http://localhost:8000
quarkus.dynamodb.aws.region=us-east-1
quarkus.dynamodb.aws.credentials.type=static
quarkus.dynamodb.aws.credentials.static-provider.access-key-id=test-key
quarkus.dynamodb.aws.credentials.static-provider.secret-access-key=test-secret
```

## Criando o DynamoDB na AWS

```
aws dynamodb create-table --table-name ImagensDB --attribute-definitions AttributeName=idName,AttributeType=S --key-schema AttributeName=idName,KeyType=HASH --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1
```

## Configs do DynamoDB na AWS : application.properties (AWS DynamoDB)

```
quarkus.dynamodb.aws.region=us-east-1
quarkus.dynamodb.aws.credentials.type=default
```

## Front-end utiliza Materialize CSS com jQuery

website: https://materializecss.com/
