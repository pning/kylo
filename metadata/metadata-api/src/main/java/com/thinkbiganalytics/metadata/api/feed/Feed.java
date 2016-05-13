/**
 * 
 */
package com.thinkbiganalytics.metadata.api.feed;

import java.io.Serializable;
import java.util.List;

import com.thinkbiganalytics.metadata.api.category.Category;
import org.joda.time.DateTime;

import com.thinkbiganalytics.metadata.api.Propertied;
import com.thinkbiganalytics.metadata.api.datasource.Datasource;

/**
 *
 * @author Sean Felten
 */
public interface Feed<C extends Category> extends Propertied, Serializable {

    interface ID extends Serializable { }

    enum State {ENABLED, DISABLED, DELETED }

    
    ID getId();
    
    String getName();
    
    String getDisplayName();
    
    String getDescription();
    
    State getState();
    
    boolean isInitialized();
    
    FeedPrecondition getPrecondition();
    
    List<FeedSource> getSources();
    
    FeedSource getSource(Datasource.ID id);
    
    FeedSource getSource(FeedSource.ID id);

    List<FeedDestination> getDestinations();

    FeedDestination getDestination(Datasource.ID id);

    FeedDestination getDestination(FeedDestination.ID id);
    

    void setInitialized(boolean flag);
    
    void setDisplayName(String name);
    
    void setDescription(String descr);
    
    void setState(State state);

     C getCategory();

    Integer getVersion();


    DateTime getCreatedTime();

    DateTime getModifiedTime();
}
