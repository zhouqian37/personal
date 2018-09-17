package cn.orange.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.orange.bean.User;
import cn.orange.mapper.UserMapper;
import cn.orange.service.excep.PasswordNotMatchException;
import cn.orange.service.excep.UserAreadyExistException;
import cn.orange.service.excep.UsernameNotFoundException;
@Service
@RequestMapping("/user")
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	/*
	 * 通过id获取用户
	 */
	public User getUserById(Integer id) {
		User user=userMapper.selectById(id);
		return user;
	}
	/*
	 * 通过username获取用户
	 */
	public User getUserByUsername(String username){
		return userMapper.selectByUsername(username);
	}
	/*
	 * 处理登录逻辑
	 */
	public User login(String username, String password) {
		User user=userMapper.selectByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("账号不存在");
		}else{
			if(user.getPassword().equals(password)){
				return user;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}
	/*
	 * 添加用户
	 */
	public void addUser(User user) {
		User user1=userMapper.selectByUsername(user.getUsername());
		if(user1==null){
			userMapper.insertUser(user);
		}else{
			throw new UserAreadyExistException("用户已存在");
		}
	}
	/*
	 * 修改密码
	 */
	public void changePwd(Integer id,String oldPwd,String newPwd,String checkPwd) {
		User user=userMapper.selectById(id);
		if(user!=null){
			if(oldPwd.equals(user.getPassword())){
				if(newPwd.equals(checkPwd)){
					User user1=new User();
					user1.setId(id);
					user1.setPassword(newPwd);
					userMapper.updateUser(user1);
				}else{
					throw new PasswordNotMatchException("新密码和确认密码不一致");
				}
			}else{
				throw new PasswordNotMatchException("旧密码不正确");
			}
		}else{
			throw new UsernameNotFoundException("用户不存在");
		}
	}
	/*
	 * 修改用户信息
	 */
	public void updateUser(Integer id,String nickname,String email,String phone) {
		User user=userMapper.selectById(id);
		if(user!=null){
			User user1=new User();
			user1.setId(id);
			if(!nickname.equals("")){
				user1.setNickname(nickname);
			}else{
				user1.setNickname(user.getNickname());
			}
			if(!email.equals("")){
				user1.setEmail(email);
			}else{
				user1.setEmail(user.getEmail());
			}
			if(!phone.equals("")){
				user1.setPhone(phone);
			}else{
				user1.setPhone(user.getPhone());
			}
			userMapper.updateUser(user1);
		}else{
			throw new UsernameNotFoundException("用户不存在");
		}
	}
}
