#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	std::string line;
	std::getline(std::cin, line);
	std::string ans;
	
	if (line[0] == 'I') {
		ans.append("E");
	} else {
		ans.append("I");
	}

	if (line[1] == 'S') {
		ans.append("N");
	}
	else {
		ans.append("S");
	}

	if (line[2] == 'T') {
		ans.append("F");
	}
	else {
		ans.append("T");
	}

	if (line[3] == 'P') {
		ans.append("J");
	}
	else {
		ans.append("P");
	}

	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}