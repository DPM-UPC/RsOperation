package pe.edu.upc.RsOperation.repositories;

import pe.edu.upc.RsOperation.domains.Category;
import pe.edu.upc.RsOperation.domains.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> listTag() throws Exception;
    Tag getTag(Tag tag) throws Exception;
}
