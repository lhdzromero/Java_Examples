package pkg.desing.patterns.behavior.iterator;

public interface ChannelCollection {
    public void addChannel (Channel c);
    
    public void removeChannel(Channel c);
    
    public ChannelIterator iterator(ChannelTypeEnum type);
}
