package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.Amplua;
import ua.victoria.app.entity.Position;
import ua.victoria.app.repository.AmpluaRepository;
import ua.victoria.app.service.AmpluaService;

@Service
public class AmpluaServiceImpl implements AmpluaService{

	@Autowired
	private AmpluaRepository ampluaRepository;
	
	@Override
	public void save(Amplua amlpua) {
		
		ampluaRepository.save(amlpua);
	}

	@Override
	public List<Amplua> findAllAmplua() {
		
		return ampluaRepository.findAll();
	}

	@Override
	public Amplua findAmpluaById(int id) {
		
		return ampluaRepository.findOne(id);
	}

	@Override
	public void createAmplua() {
		Position[] list = Position.values();
		for (int i = 0; i < list.length; i++) {
			Position position = list[i];
			Amplua amplua = new Amplua(position);
			save(amplua);
		}
		
	}

}
