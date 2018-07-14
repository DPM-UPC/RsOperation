package pe.edu.upc.RsOperation.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.RsOperation.models.Tag;
import pe.edu.upc.RsOperation.repositories.TagDao;

import java.util.List;

@Service
public class TagService {
    private static final Logger LOGGER = LogManager.getLogger(TagService.class);


    @Autowired
    TagDao tagDao;
    public List<Tag> listTag() throws Exception {
        LOGGER.debug("listTag, listTag: {}", "");
        return tagDao.listTag();
    }

    public Tag getTag(Tag tag) throws Exception {
        LOGGER.debug("getTag, getTag: {}",tag);
        return tagDao.getTag(tag);
    }
}
