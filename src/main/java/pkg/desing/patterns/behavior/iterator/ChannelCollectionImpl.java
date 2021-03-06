package pkg.desing.patterns.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {
    
    private List<Channel> channelList;
    
    public ChannelCollectionImpl(){
        channelList = new ArrayList<>();
    }
    
    public void addChannel(Channel c){
        this.channelList.add(c);
    }
    
    public void removeChannel(Channel c){
        this.channelList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type){
        return new ChannelIteratorImpl (type, this.channelList);
    }
    
    
    private class ChannelIteratorImpl implements ChannelIterator{
        
        private ChannelTypeEnum type;
        private List<Channel> channels;
        private int position;
        
        public ChannelIteratorImpl(ChannelTypeEnum ty, List<Channel> channelList){
            this.type = ty;
            this.channels = channelList;
        }
        
        @Override
        public boolean hasNext(){
            while(position < channels.size()){
                Channel c = channels.get(position);
                if(c.getTYPE().equals(type)|| type.equals(ChannelTypeEnum.ALL)){
                    return true;
                }else   
                    position++;
                }
             return false;  
            }
            
        @Override
        public Channel next(){
            Channel c = channels.get(position);      
            position++;
            return c;
        }       
    }       
 }    