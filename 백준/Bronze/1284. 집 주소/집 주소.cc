#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {

	std::string line;
	std::string ans;


	while (true) {
		std::getline(std::cin, line);
		if (line == "0") break;
		
		int size = line.size() + 1;
		for (int i = 0; i < line.size(); ++i) {
			if (line[i] == '1') {
				size += 2;
			} else if (line[i] == '0') {
				size += 4;
			} else {
				size += 3;
			}
		}

		ans.append(std::to_string(size)).append("\n");
	}

	std::cout << ans << std::flush;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}