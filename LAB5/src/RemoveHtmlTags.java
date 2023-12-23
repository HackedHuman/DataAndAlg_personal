public class RemoveHtmlTags {
    public static void main(String[] args) {
        String htmlText = "<div><p>Символи круглих дужок <code>'('</code> та <code>')'</code>." +
                " <br />Ці символи дозволяють отримати з рядка додаткову інформацію." +
                "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію" +
                " за заданим виразом і знаходить її - він просто повертає знайдений рядок." +
                "</p><p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, " +
                "щоб життя медом не здавалося.</p></div>";
        String regex = "<[^>]+>";

        String result = htmlText.replaceAll(regex, "");
        System.out.println(result);
    }
}