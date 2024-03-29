package dev.knowhowto.kafkastreaminitialize;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Component;

@ManagedResource(objectName = "dev.iqkv.kafka.streams.start:name=KafkaManagedBean")
@Component
public class KafkaManagedBean {
  private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

  public KafkaManagedBean(StreamsBuilderFactoryBean streamsBuilderFactoryBean) {
    this.streamsBuilderFactoryBean = streamsBuilderFactoryBean;
  }

  @ManagedAttribute(description = "Get the topology description")
  public String getTopologyDescription() {
    var topology = streamsBuilderFactoryBean.getTopology();
    return (topology != null) ? topology.describe().toString() : "";
  }
}
