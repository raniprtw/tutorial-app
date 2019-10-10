package service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.MenuServiceImpl;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImpltTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @Mock
    MenuDb menuDb;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        MenuModel newModel = new MenuModel();
        RestoranModel newRestoran = new RestoranModel();
        newModel.setNama("mekdi");
        newModel.setDeskripsi("a la carte");
        newModel.setDurasiMasak(20);
        newModel.setHarga(BigInteger.valueOf(35000));
        newModel.setRestoran(newRestoran);
        newModel.setId(Long.valueOf(1));
        menuService.addMenu(newModel);
        verify(menuDb, times(1)).save(newModel);
    }

    @Test
    public void whenGetMenuListCalledItShouldReturnAllRestoran() {
        List<MenuModel> allMenu = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenu.add(new MenuModel());
        }
        when (menuService.getMenuList()).thenReturn(allMenu);
        List<MenuModel> dataFromServiceCall = menuService.getMenuList();
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDb, times(1)).findAll();
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeRestoranData(){
        MenuModel updatedData = new MenuModel();
        //MenuModel nullMenu = new MenuModel();
        RestoranModel newRestoran = new RestoranModel();

        updatedData.setNama("mekdi");
        updatedData.setDeskripsi("a la carte");
        updatedData.setDurasiMasak(20);
        updatedData.setHarga(BigInteger.valueOf(35000));
        updatedData.setRestoran(newRestoran);
        updatedData.setId(Long.valueOf(1));

        when(menuDb.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);
        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);
        assertEquals("mekdi", dataFromServiceCall.getNama());
        assertEquals("a la carte", dataFromServiceCall.getDeskripsi());
        assertEquals(Integer.valueOf(20), dataFromServiceCall.getDurasiMasak());
        assertEquals(BigInteger.valueOf(35000), dataFromServiceCall.getHarga());
        assertEquals(newRestoran, dataFromServiceCall.getRestoran());
        assertEquals(Long.valueOf(1), dataFromServiceCall.getId());
        verify(menuDb, times(1)).save(updatedData);

    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuDataWithThrow() {
        MenuModel updatedData = new MenuModel();
        updatedData.setId((long)1);
        updatedData.setNama("kaefci");
        updatedData.setHarga(BigInteger.valueOf(500));
        updatedData.setDurasiMasak(500);
        updatedData.setDeskripsi("enak");
        when(menuDb.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenThrow(NullPointerException.class);
        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);
        assertEquals(null, dataFromServiceCall);
    }

    @Test
    public void whenFindAllMenuByIdRestoranItShouldFindAllMenuByIdRestoran(){
        RestoranModel newRestoran = new RestoranModel();
        newRestoran.setIdRestoran((long)1);

        List<MenuModel> allMenu = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            MenuModel menuModel = new MenuModel();
            menuModel.setRestoran(newRestoran);
            allMenu.add(menuModel);
        }

        when (menuService.findAllMenuByIdRestoran(1)).thenReturn(allMenu);
        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1);
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDb, times(1)).findByRestoranIdRestoran(Long.valueOf(1));

    }

    @Test
    public void whenFindMenuById(){
        MenuModel newModel = new MenuModel();
        newModel.setId(Long.valueOf(1));

        when (menuService.findMenuById(1)).thenReturn(Optional.of(newModel));
        Optional<MenuModel> dataFromServiceCall = menuService.findMenuById(1);
        assertEquals(newModel, dataFromServiceCall.get());
        verify(menuDb, times(1)).findById(1L);
    }

    @Test
    public void whenDeleteMenuItShouldDeleteMenu(){
        MenuModel newModel = new MenuModel();
        newModel.setId(Long.valueOf(1));


        menuService.deleteMenu(1L);
        verify(menuDb, times(1)).deleteById(1L);
    }

    @Test
    public void whenGetListMenuByHargaAscItShouldGetListMenuByHargaAsc(){
        RestoranModel newRestoran = new RestoranModel();
        newRestoran.setIdRestoran((long)1);

        List<MenuModel> allMenu = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            MenuModel menuModel = new MenuModel();
            menuModel.setHarga(BigInteger.valueOf(15000 + (loopTimes*1000)));
            menuModel.setRestoran(newRestoran);
            allMenu.add(menuModel);
        }

        when(menuService.getListMenuOrderByHargaAsc((long) 1)).thenReturn(allMenu);
        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDb, times(1)).findByRestoranIdRestoranOrderByHargaAsc(1L);

    }

}
