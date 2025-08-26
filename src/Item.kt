import java.awt.*
import javax.swing.*
import javax.swing.border.EmptyBorder

data class Item(val nome: String, val quantidade: Int, val imagem: String)

fun main() {
    val itens = listOf(
        Item("Pokébola", 10, "pokeball.png"),
        Item("Great Ball", 5, "greatball.png"),
        Item("Fruta Razz", 7, "razzberry.png"),
        Item("Golden Razz", 2, "goldenrazzberry.png")
    )

    val frame = JFrame("Inventário de Itens")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(400, 400)
    frame.layout = BorderLayout()

    val painel = JPanel()
    painel.layout = GridLayout(0, 2, 10, 10) // 2 colunas, espaçamento 10px
    painel.border = EmptyBorder(10, 10, 10, 10)

    for (item in itens) {
        val card = JPanel()
        card.layout = BorderLayout()
        card.border = BorderFactory.createLineBorder(Color.BLACK, 2)

        
        val imagem = JLabel()
        val icon = ImageIcon("src/${item.imagem}") 
        val resizedIcon = ImageIcon(icon.image.getScaledInstance(64, 64, Image.SCALE_SMOOTH))
        imagem.icon = resizedIcon
        imagem.horizontalAlignment = SwingConstants.CENTER

        val label = JLabel("<html><center>${item.nome}<br>Qtd: ${item.quantidade}</center></html>")
        label.horizontalAlignment = SwingConstants.CENTER

        card.add(imagem, BorderLayout.CENTER)
        card.add(label, BorderLayout.SOUTH)

        painel.add(card)
    }

    frame.add(painel, BorderLayout.CENTER)
    frame.isVisible = true
}
