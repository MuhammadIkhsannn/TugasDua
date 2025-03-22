package com.example.logindanregistrasi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuMakananActivity : AppCompatActivity() {
    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuAdapter: MyAdapter
    private lateinit var listMenu: ArrayList<ItemData>

//    data untuk ditampilkan di recyclerview di dalam method onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_makanan)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // RecyclerView
        menuRecyclerView = findViewById(R.id.menuRecyclerView)
        listMenu = ArrayList()

        listMenu.add(ItemData(R.drawable.nasigoreng, "Nasi Goreng", "Nasi Goreng adalah ikon kuliner Indonesia yang telah mendunia. Nasi yang digoreng bersama bumbu dasar seperti bawang merah, bawang putih, cabai, dan kecap manis ini menghasilkan hidangan yang aromatik dan menggugah selera. Nasi goreng biasanya ditambahkan telur, potongan daging ayam atau sosis, dan disajikan dengan pelengkap seperti kerupuk, acar timun-wortel, serta irisan mentimun dan tomat. Satu porsi nasi goreng bisa jadi menu makan malam favorit karena praktis, lezat, dan mengenyangkan."))
        listMenu.add(ItemData(R.drawable.nasikuning, "Nasi Kuning", "Nasi Kuning adalah simbol kebahagiaan dan perayaan dalam budaya Indonesia. Nasi ini dimasak menggunakan santan dan kunyit yang memberi warna kuning cerah dan aroma harum. Biasanya disajikan dengan beragam lauk seperti abon sapi, telur dadar iris, bihun goreng, kacang tanah goreng, dan sambal. Rasanya gurih dan sedikit manis, sangat cocok disajikan pada acara-acara spesial atau sebagai menu sarapan yang bergizi."))
        listMenu.add(ItemData(R.drawable.sotoayam, "Soto Ayam", "Soto Ayam adalah sup khas Indonesia dengan kuah bening kekuningan dari kunyit. Di dalamnya terdapat suwiran ayam, soun, kol, irisan telur rebus, dan kadang-kadang kentang goreng atau emping. Rasanya ringan namun kaya akan aroma rempah. Disajikan panas-panas dengan sambal, perasan jeruk nipis, dan taburan bawang goreng, soto ayam adalah pilihan terbaik untuk sarapan, makan siang, maupun saat cuaca dingin."))
        listMenu.add(ItemData(R.drawable.mieayam, "Mie Ayam", "Mie Ayam adalah sajian mie khas Indonesia yang disukai semua kalangan. Mie kuning direbus dan disajikan dengan topping ayam cincang yang ditumis dengan kecap manis, bawang putih, dan sedikit jahe. Disertai sawi rebus, taoge, dan taburan bawang goreng serta daun bawang, mie ayam memberikan rasa gurih manis yang khas. Biasanya dilengkapi dengan kuah kaldu di mangkuk terpisah dan sambal sesuai selera."))
        listMenu.add(ItemData(R.drawable.ayambakar, "Ayam Bakar", "Ayam Bakar adalah sajian khas Nusantara yang menggoda selera dengan aroma smokey dan cita rasa rempah yang meresap sempurna ke dalam daging ayam. Proses pembuatannya dimulai dengan merendam potongan ayam dalam bumbu tradisional seperti bawang putih, ketumbar, jahe, kunyit, dan kecap manis. Setelah dimarinasi, ayam dipanggang di atas bara api hingga bagian luar tampak kecokelatan dan mengilap. Ayam bakar biasanya disajikan bersama lalapan segar seperti kol, timun, tomat, dan sambal pedas yang memperkuat sensasi rasa khas Indonesia."))
        listMenu.add(ItemData(R.drawable.ayamgeprek, "Ayam Geprek", "Ayam Geprek merupakan perpaduan antara ayam goreng crispy ala barat dan sambal pedas tradisional Indonesia. Ayam yang telah digoreng renyah dengan tepung khas kemudian “digeprek” atau ditekan bersama sambal bawang yang dibuat dari cabai rawit, bawang putih, dan sedikit perasan jeruk. Rasanya pedas, gurih, dan sangat menggugah selera, apalagi ketika disajikan dengan nasi putih hangat, irisan timun, tomat, dan selada segar. Cocok untuk pecinta makanan pedas sejati!"))
        listMenu.add(ItemData(R.drawable.bakso, "Bakso", "Bakso adalah comfort food sejuta umat di Indonesia yang menawarkan kelezatan bola daging sapi kenyal dalam kuah kaldu gurih. Versi komplit ini biasanya terdiri dari bakso daging, tahu isi, mie kuning atau bihun, sayur, dan pangsit goreng yang renyah. Disajikan dengan taburan bawang goreng, seledri cincang, serta sambal, kecap, dan cuka sesuai selera. Setiap suapan menghadirkan rasa yang hangat, cocok disantap kapan saja."))
        listMenu.add(ItemData(R.drawable.cotomakassar, "Coto Makassar", "Coto Makassar adalah sup khas Sulawesi Selatan yang dibuat dari jeroan dan daging sapi, dimasak dalam kaldu yang kaya rasa. Kuahnya berwarna cokelat keruh karena menggunakan kacang tanah sangrai yang ditumbuk dan campuran rempah-rempah seperti serai, ketumbar, dan kayu manis. Coto biasanya disajikan bersama ketupat dan taburan daun bawang serta bawang goreng, menciptakan harmoni rasa yang kompleks dan dalam. Sajian ini menggambarkan warisan kuliner Bugis-Makassar yang kuat dan menggugah."))
        listMenu.add(ItemData(R.drawable.ikanbakar, "Ikan Bakar", "Ikan Bakar adalah sajian laut yang digemari di berbagai daerah Indonesia. Ikan segar, seperti nila atau gurame, dibumbui dengan campuran bawang merah, bawang putih, kunyit, cabai, dan kecap manis lalu dibakar di atas arang hingga matang sempurna. Hasilnya adalah ikan dengan tekstur lembut, kulit garing, dan rasa bumbu yang meresap. Biasanya disajikan dengan sambal terasi dan lalapan segar, menjadikannya hidangan yang nikmat dan sehat."))
        listMenu.add(ItemData(R.drawable.nasipadang, "Nasi Padang", "Nasi Padang adalah bentuk sempurna dari hidangan Minangkabau yang kaya akan cita rasa. Disajikan dengan nasi putih dan aneka lauk seperti rendang daging, ayam pop, gulai ayam, perkedel kentang, sambal ijo, dan daun singkong rebus. Masing-masing lauk memiliki rasa yang khas, dari gurih, pedas, hingga creamy. Nasi Padang terkenal dengan teknik penyajiannya yang “dimarakkan” (disajikan semua lauk di meja), menawarkan pengalaman makan yang mewah dan otentik."))

        // definisikan RecyclerView bersama Adapter dan layout manager
        menuRecyclerView.layoutManager = LinearLayoutManager(this)
        menuRecyclerView.setHasFixedSize(true)
        menuAdapter = MyAdapter(listMenu)
        menuRecyclerView.adapter = menuAdapter
    }

    // action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // menu item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile -> {
                startActivity(Intent(this, ProfilActivity::class.java))
                true
            }
            R.id.logout -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }
            R.id.about -> {
                startActivity(Intent(this, Activity_About::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
