package imagens;

import java.util.Map;
import java.util.Objects;

import io.quarkus.runtime.annotations.RegisterForReflection;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@RegisterForReflection
public class Imagem {

    private String name; // id
    private String description; // url

    public Imagem() {
    }

    public static Imagem from(Map<String, AttributeValue> item) {
        Imagem img = new Imagem();
        if (item != null && !item.isEmpty()) {
            img.setName(item.get(RepoDynDBService.NAME_COL).s());
            img.setDescription(item.get(RepoDynDBService.DESC_COL).s());
        }
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Imagem)) {
            return false;
        }

        Imagem other = (Imagem) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}