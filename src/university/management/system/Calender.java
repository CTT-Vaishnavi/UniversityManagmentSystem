package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calender extends JFrame {
    private List<Event> events = new ArrayList<>();
    private JList<Event> eventList;
    private DefaultListModel<Event> listModel;
    private JButton addButton, editButton, deleteButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calender().setVisible(true));
    }

    public Calender() {
        setTitle("Calendar Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        listModel = new DefaultListModel<>();
        eventList = new JList<>(listModel);
        addButton = new JButton("Add Event");
        editButton = new JButton("Edit Event");
        deleteButton = new JButton("Delete Event");

        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(addButton);
        controlPanel.add(editButton);
        controlPanel.add(deleteButton);

        add(new JScrollPane(eventList), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Event newEvent = createNewEvent();
                if (newEvent != null) {
                    events.add(newEvent);
                    updateEventList();
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Event selectedEvent = eventList.getSelectedValue();
                if (selectedEvent != null) {
                    editEvent(selectedEvent);
                    updateEventList();
                } else {
                    JOptionPane.showMessageDialog(Calender.this, "No event selected to edit.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Event selectedEvent = eventList.getSelectedValue();
                if (selectedEvent != null) {
                    int confirmation = JOptionPane.showConfirmDialog(Calender.this, "Are you sure you want to delete this event?");
                    if (confirmation == JOptionPane.YES_OPTION) {
                        events.remove(selectedEvent);
                        updateEventList();
                    }
                } else {
                    JOptionPane.showMessageDialog(Calender.this, "No event selected to delete.");
                }
            }
        });
    }

    private Event createNewEvent() {
        String name = JOptionPane.showInputDialog(this, "Enter event name:");
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Event name cannot be empty.");
            return null;
        }

        String dateStr = JOptionPane.showInputDialog(this, "Enter event date (yyyy-MM-dd):");
        if (dateStr == null || dateStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Event date cannot be empty.");
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateStr);
            return new Event(name, date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.");
        }
        return null;
    }

    private void editEvent(Event event) {
        String newName = JOptionPane.showInputDialog(this, "Enter new event name:", event.getName());
        if (newName == null || newName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Event name cannot be empty.");
            return;
        }

        String newDateStr = JOptionPane.showInputDialog(this, "Enter new event date (yyyy-MM-dd):", event.getDateStr());
        if (newDateStr == null || newDateStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Event date cannot be empty.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date newDate = dateFormat.parse(newDateStr);
            event.setName(newName);
            event.setDate(newDate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    private void updateEventList() {
        listModel.clear();
        for (Event event : events) {
            listModel.addElement(event);
        }
    }
}

class Event {
    private String name;
    private Date date;

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateStr() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    

    @Override
    public String toString() {
        return "Event: " + name + " Date: " + getDateStr();
        
    }
}
