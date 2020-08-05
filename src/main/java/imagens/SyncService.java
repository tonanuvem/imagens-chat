package imagens;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@ApplicationScoped
public class SyncService extends RepoDynDBService {

    @Inject
    DynamoDbClient dynamoDB;

    public List<Imagem> findAll() {
        return dynamoDB.scanPaginator(scanRequest()).items().stream()
                .map(Imagem::from)
                .collect(Collectors.toList());
    }

    public List<Imagem> add(Imagem img) {
        dynamoDB.putItem(putRequest(img));
        return findAll();
    }
    
    public List<Imagem> delete(Imagem img) {
        dynamoDB.deleteItem(deleteRequest(img));
        return findAll();
    }

    public Imagem get(String name) {
        return Imagem.from(dynamoDB.getItem(getRequest(name)).item());
    }
}