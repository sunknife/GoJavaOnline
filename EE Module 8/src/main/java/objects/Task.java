package objects;


public class Task {
    private String name;
    private String category;
    private boolean checked;

    public Task(String name, String category, boolean isChecked) {
        this.name = name;
        this.category = category;
        this.checked = isChecked;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", isChecked=" + checked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!name.equals(task.name)) return false;
        return category.equals(task.category);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}
