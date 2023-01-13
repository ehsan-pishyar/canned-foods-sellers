package ir.androad.cache.local.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import ir.androad.cache.AppDatabase
import ir.androad.cache.daos.SellerDao
import ir.androad.cache.models.responses.SellerResponseEntity
import kotlinx.coroutines.runBlocking
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class SellerDaoTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var sellerDao: SellerDao

    @Before
    fun setup() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        sellerDao = appDatabase.sellerDao()
    }

    @After
    fun teardown() {
        appDatabase.close()
    }

    @Test
    fun insertSeller() = runBlocking {
        val seller = SellerResponseEntity(
            id = 123456789,
            title = "جت فود",
            description = "فست فود، پیتزا، ساندویچ، غذای گرم، غذای سرد",
            logo = "logo.png",
            banner = "banner.png",
            deliveryFee = 12000,
            deliveryDuration = 20
        )

        val sellerResponseEntity = sellerDao.insertSeller(seller)

        assertThat(sellerResponseEntity).isEqualTo(seller)
    }
}