package at.cgsit.train.quarkus.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author CGS-IT Solutions @2019
 */
@Entity
@Table( name="chat_message_david")
public class ChatMessageEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="user_name", length= 100, nullable = false)
    private String userName;

    @Column(name="chat_room", length= 50, nullable = true)
    private String chatRoom;

    @Column(name="chat_message", length= 250, nullable = false)
    private String chatMessage;

    @Column(name="creation_time", nullable = true)
    private LocalDateTime creationTime;

    private Boolean isImportant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(String chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getImportant() {
        return isImportant;
    }

    public void setImportant(Boolean important) {
        isImportant = important;
    }
}
