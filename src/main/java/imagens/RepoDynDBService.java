package imagens;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public abstract class RepoDynDBService {

    public final static String NAME_COL = "idName";
    public final static String DESC_COL = "urlDescription";

    public String getTableName() {
        return "ImagensDB";
    }

    protected ScanRequest scanRequest() {
        return ScanRequest.builder().tableName(getTableName())
                .attributesToGet(NAME_COL, DESC_COL).build();
    }

    protected PutItemRequest putRequest(Imagem img) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put(NAME_COL, AttributeValue.builder().s(img.getName()).build());
        item.put(DESC_COL, AttributeValue.builder().s(img.getDescription()).build());

        return PutItemRequest.builder()
                .tableName(getTableName())
                .item(item)
                .build();
    }

    protected GetItemRequest getRequest(String name) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put(NAME_COL, AttributeValue.builder().s(name).build());

        return GetItemRequest.builder()
                .tableName(getTableName())
                .key(key)
                .attributesToGet(NAME_COL, DESC_COL)
                .build();
    }
    
    protected DeleteItemRequest deleteRequest(Imagem img) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put(NAME_COL, AttributeValue.builder().s(img.getName()).build());

        return DeleteItemRequest.builder()
                .tableName(getTableName())
                .key(key)
                //.attributesToGet(FRUIT_NAME_COL, FRUIT_DESC_COL)
                .build();
    }    
}