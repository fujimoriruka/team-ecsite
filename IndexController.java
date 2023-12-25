package jp.co.internous.nexus.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.nexus.model.domain.MstCategory;
import jp.co.internous.nexus.model.domain.MstProduct;
import jp.co.internous.nexus.model.form.SearchForm;
import jp.co.internous.nexus.model.mapper.MstCategoryMapper;
import jp.co.internous.nexus.model.mapper.MstProductMapper;
import jp.co.internous.nexus.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/nexus")
public class IndexController {
	
	/*
	 * フィールド定義
	 */
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {

		int loginUserId = loginSession.getUserId();
		int tmpUserId = loginSession.getTmpUserId();
		
		Random rand = new Random();
		int newTmpUserId = -(rand.nextInt(999999998) + 1);
		
		if(loginUserId == 0) {
			if(tmpUserId == 0) {
				loginSession.setTmpUserId(newTmpUserId);
			}
		}
		
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("categories", categories);
		m.addAttribute("selected", 0);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);		
	    
		return "index";
	}
	
	/**
	 * 検索処理を行う
	 * @param f 検索用フォーム
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {

		String keywords =f.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		  
		String[] splitKeywords = keywords.split(" ");
		
		List<MstProduct> products = null;
		List<MstCategory> categories = categoryMapper.find();
		
		if(f.getCategory() == 0 && splitKeywords != null) {
			products = productMapper.findByProductName(splitKeywords);
		}else if(f.getCategory() != 0) {
			products = productMapper.findByCategoryAndProductName(f.getCategory(), splitKeywords);
		}
		
		m.addAttribute("categories", categories);
		m.addAttribute("selected", f.getCategory());
		m.addAttribute("keywords", keywords);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);		

		return "index";

	}
}
